//
//  ViewController.swift
//  ios
//
//  Created by 松本圭樹 on 2018/11/09.
//  Copyright © 2018年 keijumt. All rights reserved.
//

import UIKit
import common

class ViewController: UIViewController, GithubView {

    @IBOutlet weak var sampleLabel: UILabel!
    
    private var presenter: GithubPresenter!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        presenter = PresenterFactory().getGithubPresenter(githubView: self)
        presenter.fetchUser(userId: "keijumt")
    }
    
    func showUser(user: User) {
        sampleLabel.text = user.name
    }
    
    func showError(message: String) {
        sampleLabel.text = message
    }
    
    deinit {
        presenter.onDestroy()
    }
}
